



const ingredients = JSON.parse(document.querySelector('#ingredients').innerHTML);
const steps = JSON.parse(document.querySelector('#steps').innerHTML);
const showIngredients = document.querySelector('#showIngredients');
const showSteps = document.querySelector('#showSteps');

console.log(ingredients);
console.log(steps);

if(document.propertyIsEnumerable(ingredients)){
    console.log("ingredients is innumerable");
} else {
    console.log("ingredients is NOT innumerable");
}

if(ingredients.length > 1){
    for(let i of ingredients){
        let e = document.createElement('li');
        e.innerText = `${i.name} ${i.notes} ${i.amount} ${i.units} `;
        showIngredients.appendChild(e);
    }
} else {
    let e = document.createElement('li');
    e.innerText = `${ingredients.name} ${ingredients.notes} ${ingredients.amount} ${ingredients.units} `;
    showIngredients.appendChild(e);
}

if(steps.length > 1){
    for(let s of steps){
        let e = document.createElement('li');
        e.innerText = `${s}`;
        showSteps.appendChild(e);
    }
} else {
    let e = document.createElement('li');
    e.innerText = `${steps}`;
    showSteps.appendChild(e);
}

