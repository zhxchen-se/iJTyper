# Baseline
## Prompt-tune
This method was proposed in [`Prompt-tuned Code Language Model as a Neural Knowledge Base for Type Inference in Statically-Typed Partial Code(ASE22)`](https://dl.acm.org/doi/abs/10.1145/3551349.3556912).

The source code is from [https://github.com/SE-qinghuang/ASE-22-TypeInference](https://github.com/SE-qinghuang/ASE-22-TypeInference).

### Modification
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


## SnR
This method was proposed in [`SnR: Constraint-Based Type Inference for Incomplete Java Code Snippets(ICSE22)`](https://dl.acm.org/doi/abs/10.1145/3510003.3510061).

The source code is from [https://zenodo.org/record/5843327](https://zenodo.org/record/5843327).

