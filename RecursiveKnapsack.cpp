#include<iostream>
using namespace std;
int knapsack(int wt[],int val[],int w,int n){
	//BASE CONDITION
	if(n==0||w==0){
		return 0;
	}
	//2 CHOICES IF WT IS LESS THAN W ,IT CAN EITHER TAKE IT OR IT CANNOT TAKE IT
	if(wt[n-1]<=w){
		return max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1),knapsack(wt,val,w,n-1));
	}
	//BUT IF WT IS GREATER THEN MOVE FROM N TO THE N-1th INDEX BY DISCARDING THE WT 
	else if(wt[n-1]>w){
		return knapsack(wt,val,w,n-1);
	}
}
int main(){
	int n=4;
	int val[4]={1,4,5,7};
	int wt[4]={1,3,4,5};
	int w=7;
	cout<<knapsack(wt,val,w,n);
	return 0;
}
