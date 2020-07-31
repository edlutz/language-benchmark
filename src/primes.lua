local socket = require("socket")
-- local timestamp = socket.gettime()
-- print(timestamp)

local primes = {}
local np = 0

function fill()
    primes[0] = 2
    local n = 1
    local p = 3
    while n<np do
        local isPrime = true
        local j = 0
        local last = primes[0]
        while isPrime and last*last < p do
            if (p % last) == 0 then
                isPrime = false
            else
                j = j + 1
                last = primes[j]
            end
        end
        if isPrime then
            primes[n] = p
            n = n + 1
        end
        p = p + 2
    end
end

if arg[1] ~= nil then
    np = tonumber(arg[1])
    local t1 = socket.gettime()
    fill()
    local t2 = socket.gettime()
    local dt = t2 - t1
    print("Time spent:", dt)
    print("Number of elements:", np)
    print(" Last prime:", primes[np-1])
end
