import React from  'react';
import Navbar from './navbar';
import Home from './home';
import About from './about';
import Department from './departement';
import BestDoctors from './BestDoctors';
import Blog from './blog';
import Contact from './contact';
function Accueil(){
    return(
    <>
      <Navbar></Navbar>
      <Home></Home>
      <About></About>
      <Department></Department>
      <BestDoctors></BestDoctors>
      <Blog></Blog>
      <Contact></Contact>
    </>
      
    );

    
}
export default Accueil;