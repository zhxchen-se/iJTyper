import json
f = open("benchmark_lib_golden.json")
obj = json.load(f)
s = set()
for n, a in obj.items():
	for i in a['Best completed libs']:
		s.add(i)
print(len(s))
