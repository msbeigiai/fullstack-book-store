import { Card, CardBody, Heading, Image, VStack, Text } from "@chakra-ui/react";
import { Book } from "../entities/Book";

interface Props {
  book: Book;
}

const BookCard = ({ book }: Props) => {
  return (
    <Card size="xs">
      <Image src={book.image} maxW="50%" objectFit="cover" />
      <CardBody>
        <VStack padding={3} align="flex-start">
          <Heading fontSize="2xl">{book.title}</Heading>
          <Heading fontSize="sm">Category: {book.category}</Heading>
          <Text>Available: {book.copiesAvailable}</Text>
        </VStack>
      </CardBody>
    </Card>
  );
};

export default BookCard;
