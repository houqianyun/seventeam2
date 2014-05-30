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
		if(!isValidShape())					//�������ɶ����ʱ
		{
			return false;
		}		
		double queue[];						//������ȳ��ȵĸ���
		queue = new double[sides.length+1];	//���ȵ��ڱ߳�

		int k = 0;
		for(int i = 0;i<queue.length;i++)	//ȫ����1
		{
			queue[i]=1;
		}
		for(int i = 0;i<sides.length;i++)	//����ͬ���ȼ���queue����
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
		double M = queue[0];				//��Mһ��ֵ
		for(int i = 1;i<queue.length-1;i++)	//��������������M
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
