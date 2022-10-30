let a=[
    {
        firstName:"Steven",
        lastName:"Hancock",
        score:90
    },
    {
        firstName:"Lynette",
        lastName:"Jorgensen",
        score:100
    },
    {
        firstName:"Andrew",
        lastName:"Wilson",
        score:71
    },
    {
        firstName:"Annika",
        lastName:"Turner",
        score:82
    }
]


//Sorting
a.sort(function(a,b){
    if(a.lastName.toLocaleLowerCase()<b.lastName.toLocaleLowerCase()) return -1;
    if(a.lastName.toLocaleLowerCase()>b.lastName.toLocaleLowerCase()) return -1;
    return 0;
})

//Sorting in ascending
a.sort(function(a,b){
    return a.score-b.score
})

//Sorting in descending
a.sort(function(a,b){
    return b.score-a.score
})