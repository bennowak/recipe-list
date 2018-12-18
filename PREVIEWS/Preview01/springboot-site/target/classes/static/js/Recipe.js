module.exports = class Recipe{
    constructor(id, user, title, ingredients, steps, img){
        this.id = id;
        this.user = user;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.img = img;
    }

    getID(){
        return this.id;
    }

    getTitle(){
        return this.title;
    }

    getIMG(){
        return this.img;
    }

    toString(){
        let str = `<a href="./recipe/detail${this.getID()}" class="food">
                <div class="food__pic" style="background-image: url(${this.getIMG()})"></div>
                <div class="food__name">${this.getTitle()}</div>
            </a>`;
        return str;
    }

    toHTML(){
        let html_recipe = document.createElement("a");
        let html_r_pic = document.createElement("div");
        html_recipe.setAttribute("href", `/recipe/detail/${this.id}`);

        hstr.appendChild("div");

    }
}