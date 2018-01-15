class Solution:
    # @param A : integer
    # @return a strings
    def intToRoman(self, A):
        denoms = ['M' , 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        values = [1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1]
        remainder = A
        roman = ""

        while remainder > 0:
            for i in xrange(len(denoms)):
                if values[i] <= remainder:
                    #print "chose i={} v[i]={} d[i]={}".format(i, values[i], denoms[i])
                    roman += denoms[i]
                    remainder -= values[i]
                    #print "remainder={}".format(remainder)
                    break


        return roman
