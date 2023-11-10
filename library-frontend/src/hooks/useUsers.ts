import { useMutation } from "@tanstack/react-query";
import { User } from "../entities/User";
import APIClient from "../services/apiClient";

const apiClient = new APIClient<User>("/register");

const useUsers = () =>
  useMutation({
    mutationFn: (user: User) => apiClient.registerUser(user),
  });

export default useUsers;
