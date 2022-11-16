public class ImprovedSelectionSort {
    public static void sort(int[] a) {
        int imin, imax, temp;
		for(int n=1; n<=a.length/2; n++){
			imin=n-1;
			imax=n-1;
			for(int m=n; m<a.length-n+1; m++){
				if(a[m]<a[imin]){
					imin=m;
				} 
				if(a[m]>a[imax]){
					imax=m;
				} 
			} 
			temp=a[n-1];
			a[n-1]=a[imin];
			a[imin]=temp;
			if(imax==n-1){
			imax=imin;	
			} 
			temp=a[a.length-n];
		    a[a.length-n]=a[imax];
			a[imax]=temp;
		} 
    } 

}
