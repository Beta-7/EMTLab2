import axios from '../customAxios/axios';
const Repository = {
    getBooks: () => {
        return axios.get("/book");
    },
    rentBook: (id) => {
        return axios.get("/book/rent/"+id);
    },
    returnBook: (id) => {
        return axios.get("/book/return/"+id);
    },

    deleteBook: (id) => {
        return axios.delete("/book/"+id);
    },

    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/book/",{
            name,category,authorId,availableCopies
        });
    },

    editBook: (id, name, category, authorId, availableCopies) => {
        console.log("edit book")
        return axios.post("/book/"+id,{
            name,category,authorId,availableCopies
        });
    },

    getAuthors:()=>{
        return axios.get("/author");
    },
    addAuthor:(name, surname, countryId) =>{
        return axios.post("/author",{
            name, surname, countryId
        })
    },
    getCountries:()=>{
        return axios.get("/country");
    },
    addCountry:(name, continent)=>{
        return axios.post("/country",{
            name, continent
        })
    }

}
export default  Repository;