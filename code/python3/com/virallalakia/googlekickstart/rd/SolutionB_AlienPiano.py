#  **************************************************************************  #
#     MIT License                                                              #
#     Copyright (c) 2020 Viral Lalakia                                         #
#  **************************************************************************  #

# This is a solution for one of the problems for Google Kick Start 2020.
# Competition: Google Kick Start 2020
# Round: D
# Problem: Problem B (Alien Piano)
# Result: WA (Wrong Answer)
# Year: 2020


def solve_test(t: int) -> str:
    n = int(input())
    lst = [int(s.strip()) for s in input().split()]
    if n < 5:
        return "Case #{}: {}".format(t, 0)
    ans, tcount, direction = 0, 2, lst[1]-lst[0]
    i = 2
    while i < n:
        if lst[i] != lst[i - 1]:
            if direction * (lst[i] - lst[i - 1]) < 0:
                tcount = 2
            else:
                if tcount >= 4:
                    ans += 1
                    tcount = 1
                else:
                    tcount += 1
            direction = (lst[i] - lst[i - 1])
        i += 1
    return "Case #{}: {}".format(t, ans)


def solve_problem() -> None:
    t = int(input())
    for ti in range(1, t + 1):
        print(solve_test(ti))


solve_problem()
