//If we allow partial weights

let items=[
    {
        name:"potatoes",
        profit:10,
        weight:2
    },
    {
        name:"tomatoes",
        profit:5,
        weight:3
    },
    {
        name:"beans",
        profit:15,
        weight:5
    },
    {
        name:"onions",
        profit:7,
        weight:7
    },
    {
        name:"apples",
        profit:6,
        weight:1
    },
    {
        name:"oranges",
        profit:18,
        weight:4
    },
    {
        name:"bananas",
        profit:3,
        weight:1
    },
]

//Adding profit/weight to each object in the array
function calculate(a){
    for(i=0;i<a.length;i++){
        np=(items[i].profit/items[i].weight)
        a[i].netprofit=np
    }
    console.log(a)
}

//Sorting the array based on net 
/*
items.sort(function(a,b){
    return b.netprofit-a.netprofit
})
*/

//Adding Constraint
let constraint=15
let totalProfit=0

function knapsack(items,constraint){
    let currentBagWeight=0
    let currentBagContents=[]

    calculate(items)                //This invokes the calculate function

    items.sort(function(a,b){
        return b.netprofit-a.netprofit
    })


    for(i=0;i<items.length;i++){
        if(currentBagWeight<=constraint){
            currentBagContents.push(items[i])
            currentBagWeight+=items[i].weight
        }
    }

    console.log(currentBagContents)
    profitCalculator(currentBagContents)
}

function profitCalculator(knapsackarray){
    for(i=0;i<knapsackarray.length;i++){
        //totalProfit+=knapsackarray[i].profit
        totalProfit+=((knapsackarray[i].netprofit)*(knapsackarray[i].weight))
    }
    console.log(totalProfit)
}

knapsack(items,constraint)