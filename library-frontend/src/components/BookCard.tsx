import {
  Card,
  CardBody,
  Heading,
  Image,
  VStack,
  Text,
  HStack,
} from "@chakra-ui/react";
import { Book } from "../entities/Book";
import { FaBuffer, FaCreativeCommonsShare } from "react-icons/fa";

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
          <VStack align="flex-start">
            <HStack>
              <FaBuffer />
              <Text>Available: {book.copiesAvailable}</Text>
            </HStack>
            <HStack>
              <FaCreativeCommonsShare />
              <Text>Copies: {book.copies}</Text>
            </HStack>
          </VStack>
        </VStack>
      </CardBody>
    </Card>
  );
};

export default BookCard;
