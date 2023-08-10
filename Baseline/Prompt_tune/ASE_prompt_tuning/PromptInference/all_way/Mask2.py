#-*- coding: utf-8 -*-
import tqdm
import random
import re

def data_mask(code_tokens,percent):
    token_forbidden = ['java.lang.String', 'java.lang.Object','System.out.println',
                       'java.lang.Override','java.lang.System.out','java.lang.Throw','java.lang.Thread']
    outputMask_tokens = []

    mask_token_list = code_tokens.copy()
    # java.util.List li = new java.util.ArrayList<>(); ---> <mask><mask><mask><mask><mask> li = new java.util.ArrayList<>();
    dot_index = [index for index in range(len(mask_token_list)) if mask_token_list[index] == '.' and index<len(mask_token_list)-1 and index>0]  # got the dot index
    if len(dot_index) < 3: return outputMask_tokens  # 直接返回空的list

    for index in dot_index:
        if index == 1:
            mask_token_list[0] = '<mask>'
            continue

        # 往 dot 的前面遍历进行<mask>
        dot_left_index = index-1
        while True:
            if mask_token_list[dot_left_index].isalpha():
                if "\u0120" in mask_token_list[dot_left_index]:
                    mask_token_list[dot_left_index] = '<mask>'
                    break
                elif mask_token_list[dot_left_index] == '<mask>':
                    break
                elif dot_left_index == 0:
                    mask_token_list[dot_left_index] = '<mask>'
                    break
                else:
                    mask_token_list[dot_left_index] = '<mask>'
                    dot_left_index = dot_left_index - 1
            else:break

    # java.util.List --> <mask>.<mask>.List --> <mask><mask><mask>.List
    for dot in dot_index:
        temp_dot = dot + 1
        if temp_dot < len(mask_token_list) and \
                mask_token_list[temp_dot] == '<mask>': # 为了确保 simple name 前面的 dot 不会被 mask
            mask_token_list[dot] = '<mask>'

    # java.util.List --> <mask>.<mask>.List --> <mask><mask><mask>.List -->[java.util,(token_index)]
    masked_FQN, start, end,TAG = [], 0, 0,True
    for token_i in range(len(mask_token_list)):
        if mask_token_list[token_i] == '<mask>' and token_i not in range(start, end):
            token_temp = []  # [(token,token_index),...]
            token_temp.append([code_tokens[token_i], token_i])
            temp_j = token_i + 1
            while temp_j < len(mask_token_list) and mask_token_list[temp_j] == '<mask>':
                token_temp.append([code_tokens[temp_j], temp_j])
                temp_j = temp_j + 1
                end = temp_j
                TAG = False
            if TAG == True: continue
            token_temp.append([code_tokens[end], end])  # java.util --> java.util.
            token_temp.append([code_tokens[end + 1], end + 1])  # java.util. --> java.util.list
            tokens = [token[0] for token in token_temp]
            index = [token[1] for token in token_temp]

            masked_FQN.append(["".join(tokens), index])

    # 将列表打乱  并取出 0.15 的 fqn 进行mask
    # mask_token_select = [token for token in masked_FQN if token[0] not in token_forbidden]  # java.lang.string 不进行mask

    # 将不需要mask的FQN 取出对应的下标
    dele_index = []
    for token_bi in token_forbidden:
        for i in range(len(masked_FQN)):
            if token_bi in masked_FQN[i][0]:
                dele_index.append(i)
    mask_token_select = [masked_FQN[i] for i in range(len(masked_FQN)) if i not in dele_index]

    mask_token = [[token[0][:-2], token[1][:-2]] for token in mask_token_select]
    mask_tokens = [token for token in mask_token if token[0].count('.')>1]  # 将 dot 小于 1 的 token 删除

    # random_mask = random.sample(mask_tokens, k=int(0.75 * len(mask_tokens)))
    # maskToken = token_list.copy()  # get code token list
    # for tokenIndex in random_mask:
    #     for index in tokenIndex[1]:
    #         maskToken[index] = '<mask>'
    # outputMask_tokens.append(maskToken)

    mask_Token_1 = mask_tokens.copy()  # get fqn mask list
    while len(mask_Token_1)>0:
        random_mask = random.sample(mask_Token_1, k=int(percent * len(mask_Token_1)))
        if len(random_mask) <10: random_mask = mask_Token_1.copy()

        # 为了确保所有的FQN 均会被 mask到，所以这里会生成一组 maskToken
        for mask in random_mask:
            mask_Token_1.remove(mask)

        maskToken = code_tokens.copy()  # get code token list
        for tokenIndex in random_mask:
            for index in tokenIndex[1]:
                maskToken[index] = '<mask>'
        outputMask_tokens.append(maskToken)

    return outputMask_tokens