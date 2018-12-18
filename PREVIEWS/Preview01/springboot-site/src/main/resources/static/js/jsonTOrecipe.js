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
    let data = JSON.parse(n.innerText);
    let atag = document.createElement('a');
    let dpic = document.createElement('div');
    let dname = document.createElement('div');

    atag.setAttribute('href', `/recipe/detail/${data.id}`);
    atag.setAttribute('class', 'food');
    dpic.setAttribute('class', 'food__pic');
    dpic.setAttribute('style', `background-image: url(${data.img})`);
    dname.setAttribute('class', 'food__name');
    dname.innerHTML = data.title;
    atag.appendChild(dpic).appendChild(dname);

    recipeDiv.appendChild(atag);
}
