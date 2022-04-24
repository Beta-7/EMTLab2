import React from 'react';
import {  Link } from "react-router-dom";
import "./NavbarComponent.css";
const NavbarComponent= () =>{
    return (
        <div id={"navbar"}>
            <li>
                <Link to="/">Home</Link>
            </li>
            <li>
                <Link to="/books">Books</Link>
            </li>
            <li>
                <Link to="/categories">Categories</Link>
            </li>
        </div>
    );
}
export default NavbarComponent;