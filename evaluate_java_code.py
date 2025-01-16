import javalang
import sys
import os

if __name__ == '__main__':
    # get java file path from process arguments
    java_file_path = os.path.abspath(sys.argv[1])
    # parse java file
    with open(java_file_path, 'r') as f:
        code = f.read()
    try:
        tree = javalang.parse.parse(code)
        index = 0
        while('public' not in tree.types[index].modifiers):
            index += 1
        try:
            class_name = tree.types[index].name
        except:
            class_name = tree.types[0].name
        print(class_name)
    except Exception as e:
        print("Syntax Error")
    