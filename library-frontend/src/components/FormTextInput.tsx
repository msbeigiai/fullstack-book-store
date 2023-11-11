import {
  Alert,
  AlertIcon,
  FormControl,
  FormErrorMessage,
  FormLabel,
  Input,
} from "@chakra-ui/react";
import { useField } from "formik";

interface Props {
  id: string;
  name: string;
  label: string;
  type: string;
  placeholder: string;
}

const FormTextInput = (props: Props) => {
  const [field, meta] = useField(props);
  return (
    <FormControl marginTop={5}>
      <FormLabel htmlFor={props.id || props.name}>{props.label}</FormLabel>
      <Input className="text-input" {...field} {...props}></Input>
      {meta.touched && meta.error ? (
        <Alert className="error" status="error" mt="2">
          <AlertIcon />
          {meta.error}
        </Alert>
      ) : null}
    </FormControl>
  );
};

export default FormTextInput;
