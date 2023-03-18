import React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import {Container, Col} from 'react-bootstrap';
export default function Footer() {
  return (
    <Navbar fixed ="bottom" bg="light" variant="light">
        <Container>
            <Col lg={12} className="text-center text-muted">
                <div>Footer Section</div>
            </Col>
        </Container>

    </Navbar>
  )
}
