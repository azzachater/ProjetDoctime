import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import { Component } from 'react';
import Accueil from './components/accueil';
import SignUp from './components/signUp';
import Doctors from './components/Doctors';
import SignIn from './components/signIn';

function App() {
  return (
      <div className="App">
        <Routes>
          <Route path='/'element={<Accueil/>}/>
          <Route path='/signUp'element={<SignUp/>}/>
          <Route path='/signIn'element={<SignIn/>}/>
        </Routes>
      
      
      </div>
    
    
    
  );
}

export default App;
