import React, { useEffect } from 'react';
import $ from 'jquery';
function SignIn(){
    return (
        <>
    <section class="form-02-main">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="_lk_de">
              <div class="form-03-main">
                <div class="logo">
                  <img src="assets1/images/user.png"/>
                </div>
                <div class="form-group">
                  <input type="email" name="email" class="form-control _ge_de_ol"  placeholder="Enter Email" required="" aria-required="true"/>
                </div>

                <div class="form-group">
                  <input type="password" name="password" class="form-control _ge_de_ol" placeholder="Enter Password" required="" aria-required="true"/>
                </div>

                <div class="checkbox form-group">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id=""/>
                    <label class="form-check-label" for="">
                      Remember me
                    </label>
                  </div>
                  <a href="#">Forgot Password</a>
                </div>

                <div class="form-group">
                  <div class="_btn_04">
                    <a href="#">Login</a>
                  </div>
                </div>

                <div class="form-group pt-0">
                  <a href="/signUp"> Sign Up  </a>
                  
                </div>
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