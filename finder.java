package eg.edu.alexu.csd.datastructure.iceHockey.csX22;
import java.lang.Math;
import java.util.Arrays;
import java.awt.Point;
public class finder implements IPlayersFinder {
	 int noOfTeams=0;
	 public boolean stringContainsNumber( String s )
	 {
	     return java.util.regex.Pattern.compile( "[0-9]" ).matcher( s ).find();
	 }
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		if(photo!=null&&photo.length!=0&&(team>=0&&team<=9)) {
		int x=photo[0].length();

		char[][] array2 = new char [photo.length][x];
		int i,j,t;int count=0;
		Point []arrOfTeams = null;//its size will be the actual number of points we will
		//return it at last
		for (i = 0; i < array2.length; i++)
		{
		    array2[i]= photo[i].toCharArray();   
		}//now we got array 2d to be able to search in it 
		for(int f=0;f<array2.length;f++) {
			for(int a=0;a<array2[0].length;a++) {
				if((array2[f][a]<='9'&&array2[f][a]>='0')
						||(array2[f][a]<='Z'&&array2[f][a]>='A')) {
					continue;
				}else {
					throw new RuntimeException("ERROR : INVALID");
				}
			}
		}
		for(i=0;i<array2.length;i++) {
			for(j=i+1;j<array2.length;j++) {
			if(array2[i].length!=array2[j].length) {
				throw new RuntimeException("ERROR : INVALID");
			}
			}
		}
		if(array2[0].length>50||array2[0].length==0) {
			throw new RuntimeException("ERROR : INVALID");
		}
		if(array2.length>50||array2.length==0) {
			throw new RuntimeException("ERROR : INVALID");
		}
		if(stringContainsNumber(Arrays.deepToString(photo))==false) {
			throw new RuntimeException("No players are found");
		}
		char y=(char)(team+'0');
		int [][]arrXY =new int[3][15000];
		for(i=0;i<array2.length;i++) {
			for(j=0;j<array2[i].length;j++) {
				if(array2[i][j]==y) {
					arrXY[0][count]=j;
					arrXY[1][count]=i;
					arrXY[2][count]=-5;
					count++;
				}
			}
		}
		
		if(count==0) {
			throw new RuntimeException("No players are found");
		}
		t=0;
		int teamCounter=0;int [][]newArrOfCentres=new int [2][15000];
		int countOfNewArr=0;
		int flag=0;int counter=0;int[][]newArrXY=new int[2][15000];
		//we want loop to get all the teams
		
		
		int checker =0;int rr=0;
		while(checker==0) {
			checker=1;
			flag=0;
		for(i=0;i<count;i++) {
			flag=0;
			if(teamCounter==0) {
				if(arrXY[2][i]!=-1) {
				for(t=0;t<count;t++) {
					if(((Math.abs(arrXY[0][i]-arrXY[0][t])==1)&&
							(arrXY[1][i]==arrXY[1][t]))||
							((Math.abs(arrXY[1][i]-arrXY[1][t])==1)
									&&(arrXY[0][i]==arrXY[0][t]))
							&&arrXY[2][t]!=-1) {
						arrXY[2][t]=-1;flag=1;
						newArrXY[0][counter]=arrXY[0][t];
						newArrXY[1][counter]=arrXY[1][t];counter++;
						teamCounter++;
					}
				}
				if(flag==1) {
					arrXY[2][i]=-1;
					newArrXY[0][counter]=arrXY[0][i];
					newArrXY[1][counter]=arrXY[1][i];
					counter++;
					teamCounter++;
				}
				else {
					//team of 1 player
					arrXY[2][i]=-1;
					newArrXY[0][counter]=arrXY[0][i];
					newArrXY[1][counter]=arrXY[1][i];
					counter++;
					teamCounter++;
				}
				}
			}
			else {
				//teamCounter>0
				int check=0;
				//we will compare with team
				if(arrXY[2][i]!=-1) {
					for(int r=0;r<teamCounter;r++) {
						if(((Math.abs(arrXY[0][i]-newArrXY[0][r])==1)&&
								(arrXY[1][i]==newArrXY[1][r]))||
								((Math.abs(arrXY[1][i]-newArrXY[1][r])==1)
										&&(arrXY[0][i]==newArrXY[0][r]))) {
							check=1;
							break;
						}
					}
					if(check==1) {
						arrXY[2][i]=-1;
						newArrXY[0][counter]=arrXY[0][i];
						newArrXY[1][counter]=arrXY[1][i];
						counter++;
						teamCounter++;
					}
				}
			}
		}
		for(i=0;i<teamCounter;i++) {
			for(j=0;j<count;j++) {
				if(arrXY[2][j]!=-1) {
					if(((Math.abs(arrXY[0][j]-newArrXY[0][i])==1)&&
							(arrXY[1][j]==newArrXY[1][i]))||
							((Math.abs(arrXY[1][j]-newArrXY[1][i])==1)
									&&(arrXY[0][j]==newArrXY[0][i]))) {
						arrXY[2][j]=-1;
						newArrXY[0][counter]=arrXY[0][j];
						newArrXY[1][counter]=arrXY[1][j];
						counter++;
						teamCounter++;
					}
				}
			}
		}
		//check if >=threshold
				if(teamCounter*4>=threshold) {
					//it will be considered a real player
					//lets get maxX , minX.maxY,minY
					int maxX=newArrXY[0][0];
					int maxY=newArrXY[1][0];
					int minX=newArrXY[0][0];
					int minY=newArrXY[1][0];
					for(int g=0;g<counter;g++) {
						if(newArrXY[0][g]<minX) {
							minX=newArrXY[0][g];
						}
						if(newArrXY[0][g]>maxX) {
							maxX=newArrXY[0][g];
						}
						if(newArrXY[1][g]<minY) {
							minY=newArrXY[1][g];
						}
						if(newArrXY[1][g]>maxY) {
							maxY=newArrXY[1][g];
						}
					}
						newArrOfCentres[0][countOfNewArr]=2*minX+(maxX-minX+1);
						newArrOfCentres[1][countOfNewArr]=2*minY+(maxY-minY+1);
						countOfNewArr++;
					
					
				}
		
		
		//now arrange acc to x
		
		int tmp1,tmp2;
		for(i=0;i<countOfNewArr;i++) {
			for(j=i+1;j<countOfNewArr;j++) {
				if(newArrOfCentres[0][i]>newArrOfCentres[0][j]) {
					//swap
					tmp1=newArrOfCentres[0][i];
					tmp2=newArrOfCentres[1][i];
					newArrOfCentres[0][i]=newArrOfCentres[0][j];
					newArrOfCentres[0][j]=tmp1;
					newArrOfCentres[1][i]=newArrOfCentres[1][j];
					newArrOfCentres[1][j]=tmp2;
				}
				else if(newArrOfCentres[0][i]==newArrOfCentres[0][j]) {
					if(newArrOfCentres[1][i]>newArrOfCentres[1][j]) {
						//swap
						tmp1=newArrOfCentres[0][i];
						tmp2=newArrOfCentres[1][i];
						newArrOfCentres[0][i]=newArrOfCentres[0][j];
						newArrOfCentres[0][j]=tmp1;
						newArrOfCentres[1][i]=newArrOfCentres[1][j];
						newArrOfCentres[1][j]=tmp2;
					}
				}
			}
		}
		
		noOfTeams=countOfNewArr;
		
		arrOfTeams=new Point[countOfNewArr];
		for(i=0;i<countOfNewArr;i++) {
			arrOfTeams[i]=new Point();
		}
		for(i=0;i<countOfNewArr;i++) {
			arrOfTeams[i].x=newArrOfCentres[0][i];
			arrOfTeams[i].y=newArrOfCentres[1][i];
		}
		checker=1;
		for(rr=0;rr<count;rr++) {
			if(arrXY[2][rr]!=-1) {
				teamCounter=0;counter=0;i=rr;
				checker=0;break;
			}
		}
		
		}if(countOfNewArr==0) {
			throw new RuntimeException("No players are found");
		}
		
		return arrOfTeams;
		}
		else {
			if(photo==null||photo.length==0) {
				throw new RuntimeException("The photo is empty");
			}else {
			throw new RuntimeException("ERROR : INVALID");
			}
		}
		
	}

}