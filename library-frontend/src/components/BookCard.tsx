import { Card, CardBody, Heading, Image, VStack, Text } from "@chakra-ui/react";
import { Book } from "../entities/Book";

interface Props {
  book: Book;
}

const BookCard = ({ book }: Props) => {
  return (
    <Card>
      <Image src={book.image} boxSize="200px" />
      <CardBody>
        <VStack padding={1} align="flex-start">
          <Heading fontSize="xl">{book.title}</Heading>
          <Text>Available: {book.copiesAvailable}</Text>
        </VStack>
      </CardBody>
    </Card>
  );
};

export default BookCard;
