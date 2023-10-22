import { Card, CardBody, Heading, Image } from '@chakra-ui/react'
import { Book } from '../hooks/useBooks'

interface Props {
    book: Book
}

const BookCard = ({book}: Props) => {
  return (
    <Card>
        <Image src={book.image} boxSize="100px" />
        <CardBody>
            <Heading fontSize='2xl'>{book.title}</Heading>
        </CardBody>
    </Card>
  )
}

export default BookCard