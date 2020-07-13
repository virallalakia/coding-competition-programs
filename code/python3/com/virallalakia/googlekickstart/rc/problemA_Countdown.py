#  **************************************************************************  #
#     MIT License                                                              #
#     Copyright (c) 2020 Viral Lalakia                                         #
#  **************************************************************************  #

# This is a solution for one of the problems for Google Kick Start 2020.
# Competition: Google Kick Start 2020
# Round: C
# Problem: Problem A (Countdown)
# Result: Pass
# Year: 2020


def solve_test(t):
    n, k = [int(s) for s in input().split(" ")]
    ip = [int(s) for s in input().split(" ")]
    ans = 0
    i = 0
    while i < n:
        if ip[i] != k:
            i += 1
            continue
        f = True
        for j in range(k - 1, 0, -1):
            i += 1
            if i >= n or ip[i] != j:
                if i < n:
                    i -= 1
                f = False
                break
        if f:
            ans += 1
        i += 1
    return "Case #{}: {}".format(t, ans)


def solve_problem():
    t = int(input())
    for ti in range(1, t + 1):
        print(solve_test(ti))


solve_problem()
