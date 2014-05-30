package trying;

public class Shape {
	double sides[];
	public Shape(double sides[])
	{
		this.sides = sides;
	}
	public boolean isValidShape()
	{
		double j = 0;
		double sum = 0;
		for(int i = 0;i<sides.length;i++)
		{
			if(sides[i]<=0)return false;
			if(sides[i]>=j)
			{
				j=sides[i];
			}
			sum += sides[i];
		}
		if(j>=(sum/2))return false;
		return true;
	}
	
	public boolean hasNEqualSides(double N)
	{
		if(!isValidShape())					//当构不成多边形时
		{
			return false;
		}		
		double queue[];						//放入相等长度的个数
		queue = new double[sides.length+1];	//长度等于边长

		int k = 0;
		for(int i = 0;i<queue.length;i++)	//全部置1
		{
			queue[i]=1;
		}
		for(int i = 0;i<sides.length;i++)	//将相同长度加入queue数组
		{						
			for(int j = (i+1);j<sides.length;j++)
			{
				if(sides[i] == sides[j])
				{
					queue[k] =queue[k]+1;
				}
			}
			k++;
		}
		double M = queue[0];				//给M一初值
		for(int i = 1;i<queue.length-1;i++)	//将数组的最大数给M
		{			
			if(queue[i] >= M) 
			{
				M = queue[i];
			}
		}
		if(N != M)return false;
		return true;
	}
}
