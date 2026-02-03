// wite a program to print sum of even numbers square of an array using anonymous function and print even numbers in the array.
let a=(arr)=>{
    let sum=0
    let even=[]
    for(let i=0;i<arr.length;i++){
        if(arr[i]%2==0){
            sum+=arr[i]*arr[i]
            even.push(arr[i])
        }
    }
    console.log(sum)
    console.log(even)
};
let arr=[20,15,40,10,7]
a(arr)
