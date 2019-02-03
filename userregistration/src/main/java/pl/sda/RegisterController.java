package pl.sda;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/newUser")
public class RegisterController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/userCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();
        AddressDTO addressDTO = new AddressDTO();
        userDTO.setAddress(addressDTO);

        userDTO.setFirstName(req.getParameter("firstName"));
        userDTO.setLastName(req.getParameter("lastName"));
        userDTO.getAddressDTO().setCity(req.getParameter("city"));
        userDTO.getAddressDTO().setStreet(req.getParameter("street"));
        userDTO.getAddressDTO().setHouseNo(req.getParameter("houseNo"));

        userService.saveUser(userDTO);

        req.getRequestDispatcher("WEB-INF/userAdded.jsp").forward(req, resp);
    }
}
