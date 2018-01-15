class Solution:
    # @param A : integer
    # @return a strings
    def countAndSay(self, A):
        read = "1"
        for i in xrange(1,A):
            read = self.sayread(read)

        return read

    def sayread(self, read):
        new_read = ""
        char_denom = ''
        char_count = 0
        for c in read:
            if char_denom != c:
                if char_denom != '':
                    new_read += str(char_count) + str(char_denom)
                char_denom = c
                char_count = 1
            else:
                char_count += 1
            #print "i={} c={} char_denom={} char_count={}".format(i, c, char_denom, char_count)
        new_read += str(char_count) + str(char_denom)
        #print "new_read={}".format(new_read)

        return new_read
