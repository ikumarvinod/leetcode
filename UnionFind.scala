object Solution {
    
    def find(parent : Array[Int], i: Int) : Int = {
        if (parent(i) == -1){
            return i
        }
        find(parent, parent(i))
    }
    
    def union(parent: Array[Int], x:Int, y: Int) = {
        val xroot = find(parent, x)
        val yroot = find(parent, y)
        if (xroot != yroot){
            parent(xroot) = yroot;
        }
    }
    
    
    
    def findCircleNum(isConnected: Array[Array[Int]]): Int = {
        val parent = new Array[Int](isConnected.length)
        for (a <- 0 until parent.length){
            parent(a) = -1
        }
        for (i <- 0 until isConnected.length){
            for (j <-0 until isConnected.length){
                if(isConnected(i)(j) == 1 && i !=j){
                    union(parent, i, j)
                }
            }
        }
        var count = 0
        for (i <-0 until parent.length){
            if (parent(i) == -1){
                count = count + 1
            }
        }
        count
        
        
        
        
        
        
    }
}
