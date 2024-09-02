import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Activation() {
  const [code, setCode] = useState('');
  const navigate = useNavigate(); 
  const handleActivation = async (e) => {
    e.preventDefault();
    const headers = {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    };
    try {
      const response = await axios.post('http://localhost:8081/activation', { code }, { headers });
      console.log(response.data);
      navigate('/signIn');
      // Gérer la réponse de votre serveur ici (par exemple, afficher un message à l'utilisateur)
    } catch (error) {
      console.error("Erreur lors de l'activation du compte:", error);
    }
  };

  return (
    <>
      <section className="form-02-main">
        <div className="container">
          <div className="row">
            <div className="col-md-12" style={{ backgroundImage: 'url("assets1/images/user-background.jpg")', backgroundSize: 'cover', backgroundPosition: 'center', backgroundRepeat: 'no-repeat', minHeight: '100vh' }}>
              <div className="_lk_de">
                <div className="form-03-main">
                  <div className="logo">
                    <img src="assets1/images/user.png" alt="user" />
                  </div>
                  <form onSubmit={handleActivation}>
                    <div className="form-group">
                      <input type="text" name="code" className="form-control _ge_de_ol" placeholder="code" onChange={(e) => setCode(e.target.value)} required aria-required="true" />
                    </div>

                    <div className="form-group">
                      <div className="_btn_04">
                        <button type="submit">Send</button>
                      </div>
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
}

export default Activation;
