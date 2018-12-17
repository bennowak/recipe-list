// const Recipe = require('./Recipe');

class Recipe {
    constructor(id, user, title, ingredients, steps, img) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.img = img;
    }

    getID() {
        return this.id;
    }

    getTitle() {
        return this.title;
    }

    getIMG() {
        return this.img;
    }

    toString() {
        let str = `<a href="./recipe/detail/${this.getID()}" class="food">
                <div class="food__pic" style="background-image: url(${this.getIMG()})"></div>
                <div class="food__name">${this.getTitle()}</div>
            </a>`;
        return str;
    }
}



const jsonElementHidden = document.querySelector("#jsonVals")
    .querySelectorAll("li");

const recipeDiv = document.querySelector("#recipes");

for(let n of jsonElementHidden){
    console.log(n.innerText);
    let data = JSON.parse(n.innerText);
    console.log(data);
    let r = new Recipe(data.id, data.user, data.title, data.ingredients, data.steps, data.img);;
    let recipe_div = document.createElement("div");
    recipe_div.innerHTML = r.toString();
    recipeDiv.appendChild(recipe_div);
    console.log(r.toString());
}
