import  React from 'react';
import Nav from './nav';
function Navbar(){
    return(
        <div>
            <div className="py-1 bg-black top">
    	<div className="container">
    		<div className="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div className="col-lg-12 d-block">
		    		<div className="row d-flex">
		    			<div className="col-md pr-4 d-flex topper align-items-center">
					    	<div className="icon mr-2 d-flex justify-content-center align-items-center"><span className="icon-phone2"></span></div>
						    <span className="text">+ 1235 2355 98</span>
					    </div>
					    <div className="col-md pr-4 d-flex topper align-items-center">
					    	<div className="icon mr-2 d-flex justify-content-center align-items-center"><span className="icon-paper-plane"></span></div>
						    <span className="text">doctime@gmail.com</span>
					    </div>
					    <div className="col-md-5 pr-4 d-flex topper align-items-center text-lg-right justify-content-end">
						    <p className="mb-0 register-link"><a href="/signUp" className="mr-3">Sign Up</a><a href="/signIn">Sign In</a></p>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
            </div>
            <Nav></Nav>
        
        </div>
    );
}
export default Navbar;