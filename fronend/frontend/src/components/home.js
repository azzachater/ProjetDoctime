import React from 'react';

function Home() {
  return (
    <section className="hero-wrap js-fullheight" style={{backgroundImage: `url(${process.env.PUBLIC_URL}/assets/images/bg_3.jpg)`}} data-section="home" data-stellar-background-ratio="0.5">
      <div className="overlay"></div>
      <div className="container">
        <div className="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
          <div className="col-md-6 pt-5 ftco-animate">
          	<div className="mt-5">
          		<span className="subheading">Welcome to DocTime</span>
	            <h1 className="mb-4">We are here <br/>for your Care</h1>
	            <p className="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove.</p>
	            <p><a href="#" className="btn btn-primary py-3 px-4">Make an appointment</a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Home;
