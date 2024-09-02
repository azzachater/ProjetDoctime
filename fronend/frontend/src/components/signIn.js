import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import $ from 'jquery';
function SignIn(){
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); 
  const handleLogin = async (e) => {
    e.preventDefault();
    const headers = {
      'Content-Type': 'application/json',
    };
    try {
      const response = await axios.post('http://localhost:8081/connexion', { email, password }, { headers });
    
    // Récupérer le jeton JWT de la réponse
    const token = response.data.bearer;

    // Vérifier si le jeton est présent
    if (token) {
      // Stocker le jeton dans le stockage local
      localStorage.setItem('bearer', token);
      
      // Rediriger l'utilisateur vers la page principale ou toute autre page appropriée
      navigate('/department');
    } else {
      console.error('Le jeton JWT n\'a pas été reçu dans la réponse.');
    }
  } catch (error) {
      console.error('Erreur lors de la connexion:', error);
    }
  };
    return (
        <>
    <section className="form-02-main">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="_lk_de">
              <div className="form-03-main">
                <div className="logo">
                  <img src="assets1/images/user.png"/>
                </div>
                <form onSubmit={handleLogin}>
                <div className="form-group">
                  <input type="email" name="email" className="form-control _ge_de_ol"  placeholder="Enter Email" required="" aria-required="true" onChange={(e) => setEmail(e.target.value)}/>
                </div>

                <div className="form-group">
                  <input type="password" name="password" className="form-control _ge_de_ol" placeholder="Enter Password" required="" aria-required="true" onChange={(e) => setPassword(e.target.value)}/>
                </div>

                

                <div className="form-group">
                      <div className="_btn_04">
                        <button type="submit">Login</button>
                      </div>
                    </div>

                <div className="form-group pt-0">
                  <a href="/department"> Sign Up  </a>
                  
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    </>
      );
    };
    
    export default SignIn;