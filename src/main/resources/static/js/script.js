console.log("Script loaded");


//get the theme change button
let currentTheme=getTheme();
//initial ->
changeTheme(currentTheme);

//todo
function changeTheme(currentTheme){
//set to web page
document.querySelector('html').classList.add(currentTheme);

//set the listener to change theme button
const changeThemeButton=document.querySelector('#theme_change_button');
//change the text of button
changeThemeButton.querySelector('span').textContent = currentTheme === 'light' ? 'Light' : 'Dark';
changeThemeButton.addEventListener('click', (event) => {
    const oldTheme=currentTheme;
    // console.log("clicked");
    //remove the current theme
    // document.querySelector('html').classList.remove(currentTheme);
    if (currentTheme === 'dark') {
        //theme is light
        currentTheme = 'light';

    }else{
        //theme is dark
        currentTheme = 'dark';
    }
    //local storage update
    setTheme(currentTheme);

    //remove the current theme 
     document.querySelector('html').classList.remove(oldTheme);
    //set the current theme
    document.querySelector('html').classList.add(currentTheme);
    //change the text of button
    changeThemeButton.querySelector('span').textContent = currentTheme === 'light' ? 'Light' : 'Dark';
    
})

}

//set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}


//get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
// if(theme==null){
//     return theme
// }else{
//     return "light";
// }
}
//end of theme change
