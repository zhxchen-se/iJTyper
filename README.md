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
1. Obtain the Model from the author of [MLMTyper](https://github.com/SE-qinghuang/ASE-22-TypeInference) and place it in ~/iJTyper/Code/Baseline/Prompt_tune/ASE_prompt_tuning/PromptTuning/
2. Run ``pip install -r requirements.txt``
3. Install MariaDB(10.3.32) and create a database (name:snr, password:SnR123456*) whose settings could be seen [here](./Code/ours/knowledge_base.py). Grant all privileges to it, in case it may report some unexpected errors.
4. cd into ~/iJTyper/Code and run  ``python3 knowledge_base.py`` to construct the knowledge base.

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
 


