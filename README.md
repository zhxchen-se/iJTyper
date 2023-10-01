# iJTyper
## Overview
The source code of iJTyper is in ~/iJTyper/Code.\
The experimental data of iJTyper is in ~/iJTyper/Data.
```
iJTyper
├── Code
│   ├── Baseline
│   ├── Datasets
│   └── ours
├── Data
│   ├── Discussion
│   ├── RQ1
│   ├── RQ2
│   └── RQ3
├── README.md
└── requirements.txt
```

## Setting up iJTyper
<!-- Docker is strongly recommanded to help you ease the process of setting up iJTyper. You can access it in Google Drive. If you still want to set up iJTyper on your own, please follow the instructions below. -->
1. Environment to be satisfied

    - JDK8
    - MariaDB 10.3.32 
    - Maven
    - Linux
    - Python 3.8.10

2. Obtain the Model from the author of [MLMTyper](https://github.com/SE-qinghuang/ASE-22-TypeInference) and place it in ~/iJTyper/Code/Baseline/Prompt_tune/ASE_prompt_tuning/PromptTuning/
3. Run ``pip3 install -r requirements.txt``
4. Create a database (name:snr, password:SnR123456*) whose settings could be seen [here](./Code/ours/knowledge_base.py). Grant all privileges to it, in case it may report some unexpected errors.
5. cd into ~/iJTyper/Code and run  ``python3 knowledge_base.py`` to construct the knowledge base.

## Running iJTyper
1. Copy the code snippets into the folder [~/iJTyper/Code/ours/code_snippet/](./Code/ours/code_snippet/)
2. cd into [~/iJTyper/Code/ours](./Code/ours/)
3. Config the arguments below and run ```python3 framework.py```
```
usage: framework.py [-h] [--topk TOPK] [--iter ITER] [--gpu GPU]

iJTyper

optional arguments:
  -h, --help   show this help message and exit
  --topk TOPK  Top-K value (default: 3)
  --iter ITER  Maximum iteration rounds for one snippet (default: 10)
  --gpu GPU    GPU index (default: 0)
```
4. See the output snippet with inferred FQNs in [~/iJTyper/Code/ours/output](./Code/ours/output/); The output csv file is in [~/iJTyper/Code/ours/csv](./Code/ours/csv/)
 
## Baselines
### MLMTyper
This method was proposed in [`Prompt-tuned Code Language Model as a Neural Knowledge Base for Type Inference in Statically-Typed Partial Code(ASE22)`](https://dl.acm.org/doi/abs/10.1145/3551349.3556912).

The source code is from [https://github.com/SE-qinghuang/ASE-22-TypeInference](https://github.com/SE-qinghuang/ASE-22-TypeInference).

#### Modification
In order to **enable the source code to run on GPU in a Linux environment**, we have made minimal modifications(in` ~/Prompt-tune/ASE_prompt_tuning/PromptInference/Practicality/predDictData_line.py`), mainly correcting some errors and transferring the model and data to GPU.  Modifications are done as follows:  
- Change the jar file name from 'Spoon_FQN_3.jar' to 'Spoon_FQN.jar' (in *ground_truth* function)
- Change the *cmd* variable from '"java -jar "+jar_package+" "+lib_path' to '['java','-jar',jar_package,lib_path]' (in *ground_truth* function)
- Change the *cmd* variable from ' 'javac ' + file_path' ' to '['javac',file_path]' (in *ground_truth* function)
- Change the file splitter of json_fileName from '\\\\' to '/' (in *file_read* function )
- Change the file splitter of Spoon_FQN.jar from '\\\\' to '/'
- Change all Chinese characters in the code to English(in *predictData_Gen*,*file_writer*,*Itera_Pred()init* function)
- Move model and token tensors to GPU in (in *Itera_Pred()init*, *model_Pred*function)
- Change the *FQN_Truth_path* variable from 'FQN_truth' to 'FQN'(in *file_read* function)
- Change the *prompt_infer_path* and *prompt_tuning_path*(global variable)


### SnR
This method was proposed in [`SnR: Constraint-Based Type Inference for Incomplete Java Code Snippets(ICSE22)`](https://dl.acm.org/doi/abs/10.1145/3510003.3510061).

The source code is from [https://zenodo.org/record/5843327](https://zenodo.org/record/5843327).



