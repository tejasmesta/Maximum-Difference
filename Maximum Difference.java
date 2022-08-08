class Solution
{
    int findMaxDiff(int a[], int n)
    {
	// Your code here
	    Stack<Integer> st = new Stack<>();
	    
	    int l[] = new int[n];
	    
	    l[0] = 0;
	    
	    st.push(a[0]);
	    
	    for(int i=1;i<n;i++)
	    {
	        while(!st.isEmpty() && st.peek()>=a[i])
	        {
	            st.pop();
	        }
	        if(st.size()>0)
	        {
	            l[i] = st.peek();
	        }
	        else{
	            l[i] = 0;
	        }
	        st.push(a[i]);
	    }
	    
	    st = new Stack<>();
	    
	    int r[] = new int[n];
	    
	    r[n-1] = 0;
	    
	    st.push(a[n-1]);
	    
	    for(int i=n-2;i>=0;i--)
	    {
	        while(!st.isEmpty() && st.peek()>=a[i])
	        {
	            st.pop();
	        }
	        if(st.size()>0)
	        {
	            r[i] = st.peek();
	        }
	        else{
	            r[i] = 0;
	        }
	        st.push(a[i]);
	    }
	    
	    int ans = Integer.MIN_VALUE;
	    
	    for(int i=0;i<n;i++)
	    {
	        ans = Math.max(ans,Math.abs(l[i]-r[i]));
	    }
	    
	    return ans;
	    
    }
}