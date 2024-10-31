n = int(input())

def draw(size, patten = ['***', '* *', '***']):
    lst = []
    if size == 3:
        lst = ['***', '* *', '***']
        return lst
    if size != 9:
        patten = draw(size//3)
    for i in range(3):
        if i == 1:
            tmp = []
            for j in range(3):
    
                if j == 1:
                    for _ in range(size//3):
                        tmp.append(' '*(size//3))
                    lst.append(tmp)
                    tmp = []
                else:
                    lst.append(patten)

        else:
            for _ in range(3):
                lst.append(patten)

    for r in range(0, 9, 3):
        for i in range(size//3):
            line = ''
            for j in range(3):
                line += lst[j+r][i]# 오류
            tmp.append(line)
    return tmp

lst = draw(n)
ans = '\n'.join(lst)
print(ans)