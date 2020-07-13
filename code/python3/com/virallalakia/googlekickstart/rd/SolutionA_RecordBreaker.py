#  **************************************************************************  #
#     MIT License                                                              #
#     Copyright (c) 2020 Viral Lalakia                                         #
#  **************************************************************************  #

# This is a solution for one of the problems for Google Kick Start 2020.
# Competition: Google Kick Start 2020
# Round: D
# Problem: Problem A (Record Breaker)
# Result: WA (Wrong Answer)
# Year: 2020


def solve_test(t: int) -> str:
    n = int(input())
    lst = [int(s.strip()) for s in input().split()]
    ans, tmax = 0, 0
    for i in range(n):
        if tmax < lst[i]:
            tmax = lst[i]
            if i >= n - 1 or lst[i] > lst[i + 1]:
                ans += 1
    return "Case #{}: {}".format(t, ans)


def solve_problem() -> None:
    t = int(input())
    for ti in range(1, t + 1):
        print(solve_test(ti))


solve_problem()
