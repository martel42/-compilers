from Parser import Parser

if __name__ == "__main__":
    input = '{ c := abs ( - p + 2 & 4 mod 5 / ( 2 ) ) }'
    input = list(input.strip().split())
    print('Tokens')
    print(input)
    parser = Parser(input)