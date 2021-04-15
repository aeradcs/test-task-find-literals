'a''a'
'\\''\\'
"\\" "\\"
"\\" "\\" aaa \\\
x = 'a \' b'
y = 'a \' b'
x = 'a \" b'
y = 'a \" b'
x = "a \' b"
y = "a \' b"
x = "a \" b"
y = "a \" b"
"a \"\\ b"
"a \"\\ b"
"a \"\\"
"a \"\\"
"\""
"\""
x = 'a \' b'
y = 'a \' b'
print(x); print(y);
database = [{'id': i, "value": str(i)} for i in range(100)]

print("Hello world!")

for data in database:
    if data['id'] % 10 == 0 or data['id'] == 13:
        print(data['value'])