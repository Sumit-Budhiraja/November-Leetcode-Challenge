public int mirrorReflection(int p, int q) {

        int height = q;
        boolean left = false;

        while(height % p != 0) {
            height += q;
            left = !left;
        }
        if(left)
            return 2;
        else 
            return (height/p)%2;
    }
	