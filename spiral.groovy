// groovy spiral.groovy 24
// Ville Maanpaa -- 2013/1/23 -- prints out a spiral of numbers (exercise 3 for rally software)
def mynum=args[0].toInteger(); 
def matrix = [[7,8,9], 
                [5,0,1]         
                [4,3,2]] 
                
def size = matrix[0].size(); 
def counter=0 
if(size%2==0){ 
        size++ 
} 
def createSpiral(matrix,mynum){ 
        def direction=0.toInteger()  //right=0 down=1 left=2 up=3 
        newsize = matrix[0].size().toInteger() 
        newsize=newsize+2 
        def start=((newsize+1)/2).toInteger() 
        def x=start-1 
        def y=x 
        def totalcells=newsize*newsize 
        def i=0 
        def newmatrix=new Object[newsize][newsize]         
        for(i=0;i<totalcells;i++){ 
                     switch(direction){ 
                        case 0:         
                                while(newmatrix[y][x]!=null){ 
                                        y-- 
                                } 
                                newmatrix[y][x]=i 
                                if(i==totalcells-1){continue}
                                if(newmatrix[y][x+1]==null){ 
                                        x++; 
                                        if(newmatrix[y+1][x]==null){ 
                                                direction=1                                                 
                                        }   
                                }                            
                                break 
                        case 1: 
                                while(newmatrix[y][x]!=null){ 
                                        x++ 
                                } 
                                newmatrix[y][x]=i 
                                if(newmatrix[y+1][x]==null){
                                    y++
                                    if(newmatrix[y][x-1]==null){
                                      direction=2
                                    }
                                }
                                break 
                        case 2: 
                                while(newmatrix[y][x]!=null){ 
                                        y++ 
                                } 
                                newmatrix[y][x]=i 
                                if(newmatrix[y][x-1]==null){x--;direction=3}else{x--}  
                                break 
                        case 3: 
                                while(newmatrix[y][x]!=null){ 
                                        x-- 
                                } 
                                newmatrix[y][x]=i 
                                if(newmatrix[y-1][x]!=null){x--}else{y--;direction=0} 
                                break 
                  } 
        } 
        if(i>mynum){
          printmatrix(newmatrix,mynum)
          println ""
          println ""
          System.exit(0) 

        }else{createSpiral(newmatrix,mynum)} 
        
}         
matrix= createSpiral(matrix,mynum) 
        

def printmatrix(newmatrix,mynum){ 
               (0..<newmatrix.size()).each{index-> 
                 println ""; 
                 (0..<newmatrix[index].size()).each{j-> 
                       if(newmatrix[index][j]>mynum){ 
                       print " "         
               } else{ 
                           print newmatrix[index][j] + " " 
               } 
                 } 
               } 
}