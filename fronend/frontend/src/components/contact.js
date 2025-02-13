import React from "react";
function Contact(){
    return(
        <div>
        <section className="ftco-section contact-section" id="contact-section">
      <div className="container">
      	<div className="row justify-content-center mb-5 pb-3">
          <div className="col-md-7 heading-section text-center ftco-animate">
            <h2 className="mb-4">Contact Us</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
          </div>
        </div>
        <div className="row d-flex contact-info mb-5">
          <div className="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div className="align-self-stretch box p-4 text-center bg-light">
          		<div className="icon d-flex align-items-center justify-content-center">
          			<span className="icon-map-signs"></span>
          		</div>
          		<h3 className="mb-4">Address</h3>
	            <p>198 West 21th Street, Suite 721 New York NY 10016</p>
	          </div>
          </div>
          <div className="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div className="align-self-stretch box p-4 text-center bg-light">
          		<div className="icon d-flex align-items-center justify-content-center">
          			<span className="icon-phone2"></span>
          		</div>
          		<h3 className="mb-4">Contact Number</h3>
	            <p><a href="tel://1234567920">+ 1235 2355 98</a></p>
	          </div>
          </div>
          <div className="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div className="align-self-stretch box p-4 text-center bg-light">
          		<div className="icon d-flex align-items-center justify-content-center">
          			<span className="icon-paper-plane"></span>
          		</div>
          		<h3 className="mb-4">Email Address</h3>
	            <p><a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
	          </div>
          </div>
          <div className="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div className="align-self-stretch box p-4 text-center bg-light">
          		<div className="icon d-flex align-items-center justify-content-center">
          			<span className="icon-globe"></span>
          		</div>
          		<h3 className="mb-4">Website</h3>
	            <p><a href="#">yoursite.com</a></p>
	          </div>
          </div>
        </div>
        <div className="row no-gutters block-9">
          <div className="col-md-6 order-md-last d-flex">
            <form action="#" class="bg-light p-5 contact-form">
              <div class="form-group">
                <input type="text" className="form-control" placeholder="Your Name"/>
              </div>
              <div class="form-group">
                <input type="text" className="form-control" placeholder="Your Email"/>
              </div>
              <div class="form-group">
                <input type="text" className="form-control" placeholder="Subject"/>
              </div>
              <div class="form-group">
                <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" value="Send Message" class="btn btn-secondary py-3 px-5"/>
              </div>
            </form>
          
          </div>

          <div class="col-md-6 d-flex">
          	<div id="map" class="bg-white"></div>
          </div>
        </div>
      </div>
    </section>
    <footer class="ftco-footer ftco-section img" style={{backgrounImage: "url('assets/images/footer-bg.jpg')"}}>
    <div class="overlay"></div>
  <div class="container-fluid px-md-5">
    <div class="row mb-5">
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">DocTime</h2>
          <p>Far far away, behind the word mountains, far from the countries.</p>
          <ul class="ftco-footer-social list-unstyled mt-5">
            <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
            <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
            <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4 ml-md-4">
          <h2 class="ftco-heading-2">Departments</h2>
          <ul class="list-unstyled">
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Neurology</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Opthalmology</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Nuclear Magnetic</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Surgical</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Cardiology</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Dental</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4 ml-md-4">
          <h2 class="ftco-heading-2">Links</h2>
          <ul class="list-unstyled">
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Home</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>About</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Departments</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Doctors</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Blog</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Pricing</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
         <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">Services</h2>
          <ul class="list-unstyled">
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Emergency Services</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Qualified Doctors</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Outdoors Checkup</a></li>
            <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>24 Hours Services</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
            <h2 class="ftco-heading-2">Have a Questions?</h2>
            <div class="block-23 mb-3">
              <ul>
                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                <li><a href="#"><span class="icon icon-envelope pr-4"></span><span class="text">info@yourdomain.com</span></a></li>
              </ul>
            </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 text-center">

      <p>
        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
      </p>
      </div>
    </div>
  </div>
</footer>
</div>
    );
}
export default Contact;