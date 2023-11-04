import {
  FormControl,
  FormErrorMessage,
  FormLabel,
  Input,
} from "@chakra-ui/react";
import { useField } from "formik";
import { ReactNode } from "react";

interface Props {
  id: string;
  name: string;
  label: string;
  type: string;
  placeholder: string;
  children: ReactNode;
}

const FormTextInput = (props: Props) => {
  const [field, meta] = useField(props);
  return (
    <FormControl>
      <FormLabel htmlFor={props.id || props.name}>{props.label}</FormLabel>
      <Input className="text-input" {...field} {...props}></Input>
      {meta.touched && meta.error ? (
        <FormErrorMessage>{meta.error}</FormErrorMessage>
      ) : null}
    </FormControl>
  );
};

export default FormTextInput;
