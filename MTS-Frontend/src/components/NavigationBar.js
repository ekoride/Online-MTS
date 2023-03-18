import React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav';
import Container from 'react-bootstrap/Container';
import { Link } from 'react-router-dom';
export default function NavigationBar() {
  return (
    <>
        <Navbar bg="light" variant="light">
            <Container>
            <Link to={""} className="navbar-brand">MTS</Link>
                <Nav className="me-auto">
                    <Link to={"movies"} className="navbar-brand">Movies</Link>
                    <Link to={"movies"} className="navbar-brand">Features</Link>
                    {/* <Nav.Link href="#pricing">Pricing</Nav.Link> */}
                </Nav>
            </Container>    
        </Navbar>  

    </>
  )
}
