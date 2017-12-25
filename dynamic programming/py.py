input_str = "BANANAS"
count_dict = dict()

for char in input_str:
    count = count_dict.get(char)
    if(None == count):
        count_dict[char] = 1
    else:
        count_dict[char] = (count + 1)

print(count_dict)