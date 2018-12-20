// // const Recipe = require('./Recipe');
//




const jsonElementHidden = document.querySelector("#jsonVals")
    .querySelectorAll("li");

const recipeDiv = document.querySelector("#recipes");

for(let n of jsonElementHidden){
    let data = JSON.parse(n.innerText);
    let atag = document.createElement('a');
    let dpic = document.createElement('div');
    let dname = document.createElement('div');

    atag.setAttribute('href', `/recipes/detail/${data.id}`);
    atag.setAttribute('class', 'food');
    dpic.setAttribute('class', 'food__pic');
    dpic.setAttribute('style', `background-image: url(${data.img})`);
    dname.setAttribute('class', 'food__name');
    dname.innerHTML = data.title;
    atag.appendChild(dpic).appendChild(dname);

    recipeDiv.appendChild(atag);
}
