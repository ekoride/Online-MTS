import React from 'react'
import {Card, Table} from 'react-bootstrap';

export default function Movies() {
  return (
    <Card className='mt-5 border border-light bg-light text-black'>
        <Card.Header>Movies</Card.Header>
        <Card.Body>
            <Table striped>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Movie Name</th>
                    <th>Review</th>
                    <th>Rating</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>1</td>
                    <td>Jumanji</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    </tr>
                    <tr>
                    <td>2</td>
                    <td>Pushpa</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    </tr>
                    <tr>
                    <td>3</td>
                    <td colSpan={2}>Larry the Bird</td>
                    <td>@twitter</td>
                    </tr>
                </tbody>
            </Table>
        </Card.Body>
    </Card>
  )
}
